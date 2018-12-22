import React, {Component} from 'react';
import Modal from 'react-modal';
import SeatPicker from '../components/SeatPicker';
import TicketSelector from '../components/TicketSelector';
import PriceDisplay from '../components/PriceDisplay';
import prices from '../constants/Prices'

class ScreeningContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      screening: null,
      seatmap: null,
      selectedTickets: [],
      selectedSeats: [],
      ticketPrice: 0,
      modalIsOpen: false
    }
    this.calculatePrice = this.calculatePrice.bind(this);
    this.handleTicketSelect = this.handleTicketSelect.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
    this.ticketCount = this.ticketCount.bind(this);
    this.bookTickets = this.bookTickets.bind(this);
  }

  openModal() {
    this.setState({modalIsOpen: true});
  }

  closeModal() {
    this.setState({modalIsOpen: false});
  }

  ticketCount(){
    let total = 0;
    for(let key in this.state.selectedTickets){
      total += parseInt(this.state.selectedTickets[key]);
    }
    return total;
  }

  componentDidMount(){

      fetch(`/api/screenings/${this.props.screeningId}`)
      .then(response => response.json())
      .then(screening => this.setState({screening}))

      fetch(`/api/screenings/${this.props.screeningId}/seating`)
      .then(response => response.json())
      .then(seatmap => this.setState({seatmap}))

  }

  handleTicketSelect(selectedTickets){
    let ticketPrice = this.calculatePrice(selectedTickets);
    this.setState({selectedTickets, ticketPrice})
  }

  calculatePrice(ticketObject){
    let totalPrice = 0;
    for(let priceLevel in prices){
      totalPrice += prices[priceLevel] * ticketObject[priceLevel]
    }
    return totalPrice;
  }

  bookTickets(){
    //post ticket numbers and screening number to API
    this.closeModal();
    console.log('tickets booked!');
  }

  render(){
    return (
      <>
       <Modal isOpen={this.state.modalIsOpen}
              onRequestClose={this.closeModal}
              contentLabel="SeatPicker">
        <SeatPicker screening = {this.state.screening}
                    seatmap ={this.state.seatmap}
                    seatLimit = {this.ticketCount()}
                    handleClick = {this.bookTickets}/>
       </Modal>
      <PriceDisplay price = {this.state.ticketPrice}/>
      <TicketSelector handleSelect = {this.handleTicketSelect}
                      handleSubmit = {this.openModal}/>
      </>
    )
  }

}

export default ScreeningContainer;
