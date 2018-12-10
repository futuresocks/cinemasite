import React, {Component} from 'react';
import Modal from 'react-modal';
import TicketSelector from '../components/TicketSelector';
import PriceDisplay from '../components/PriceDisplay';
import prices from '../constants/Prices'

class ScreeningContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      selectedTickets: [],
      selectedSeats: [],
      ticketPrice: 0,
      modalIsOpen: false
    }
    this.calculatePrice = this.calculatePrice.bind(this);
    this.handleTicketSubmit = this.handleTicketSubmit.bind(this);
    this.openModal = this.openModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
  }

  openModal() {
    this.setState({modalIsOpen: true});
  }

  closeModal() {
    this.setState({modalIsOpen: false});
  }

  componentDidMount(){
    fetch(`/api/screenings/${this.props.screeningId}`)
    .then(data => data.json())
    .then(screeningInfo => console.log(screeningInfo))
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

         <h2 ref={subtitle => this.subtitle = subtitle}>Hello</h2>
         <button onClick={this.closeModal}>close</button>
         <div>I am a modal</div>
         <form>
           <input />
           <button>tab navigation</button>
           <button>stays</button>
           <button>inside</button>
           <button>the modal</button>
         </form>
       </Modal>
      <PriceDisplay price = {this.state.ticketPrice}/>
      <TicketSelector handleSubmit = {this.handleTicketSubmit}/>
      </>
    )
  }

}

export default ScreeningContainer;
