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
      selectedTickets: [],
      selectedSeats: [],
      ticketPrice: 0,
      modalIsOpen: false
    }
    this.calculatePrice = this.calculatePrice.bind(this);
    this.handleTicketSubmit = this.handleTicketSubmit.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
    this.ticketCount = this.ticketCount.bind(this);
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
    .then(data => data.json())
    .then(screening => this.setState({screening}));
  }

  handleTicketSubmit(selectedTickets){
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

  render(){
    return (
      <>
      <button onClick={this.openModal}>Open Modal</button>
       <Modal
         isOpen={this.state.modalIsOpen}
         onRequestClose={this.closeModal}
         contentLabel="Example Modal"
       >
        <SeatPicker screening = {this.state.screening} seatLimit = {this.ticketCount()}/>
       </Modal>
      <PriceDisplay price = {this.state.ticketPrice}/>
      <TicketSelector handleSubmit = {this.handleTicketSubmit}/>
      </>
    )
  }

}

export default ScreeningContainer;
