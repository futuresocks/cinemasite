import React, {Component} from 'react';
import TicketSelector from '../components/TicketSelector';
import PriceDisplay from '../components/PriceDisplay';
import prices from '../constants/Prices'

class ScreeningContainer extends Component {
  constructor(props){
    super(props);
    this.state = {
      selectedTickets: [],
      selectedSeats: [],
      ticketPrice: 0
    }
    this.calculatePrice = this.calculatePrice.bind(this);
    this.handleTicketSubmit = this.handleTicketSubmit.bind(this);
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
      <PriceDisplay price = {this.state.ticketPrice}/>
      <TicketSelector handleSubmit = {this.handleTicketSubmit}/>
      </>
    )
  }

}

export default ScreeningContainer;
