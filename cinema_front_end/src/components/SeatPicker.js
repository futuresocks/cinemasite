import React, {Component} from 'react';
import Seat from './Seat';
import UnavailableSeat from './UnavailableSeat';

class SeatPicker extends Component{
  constructor(props){
    super(props);
    this.state = {
      selectedSeats: [],
      screeningSeats: this.props.screening._embedded.room.seats
                            .map(seat => seat.number),
      bookedSeats: this.props.screening._embedded.tickets
                   .map(ticket => ticket.seat.number)
    }
    this.seatGenerator = this.seatGenerator.bind(this);
    this.handleSeatClick = this.handleSeatClick.bind(this);
  }

  handleSeatClick(seatNo){
    let selectedSeats;
    if(!this.state.selectedSeats.includes(seatNo)){
      selectedSeats = [...this.state.selectedSeats, seatNo];
    } else {
      selectedSeats = [...this.state.selectedSeats].splice(this.state.selectedSeats.indexOf(seatNo), 1);
    }
    this.setState({selectedSeats})
  }

  seatGenerator(seatNo){

    let selectedStatus = false;

    if(this.state.bookedSeats.includes(seatNo)){
      return <UnavailableSeat number = {seatNo}/>
    }

    if(this.state.selectedSeats.includes(seatNo)){
      selectedStatus = true;
    }

    return <Seat number = {seatNo}
                 selected = {selectedStatus}
                 seatClick = {this.handleSeatClick}/>
  }

  render(){

    const seats = this.state.screeningSeats.map(seatNo => this.seatGenerator(seatNo));

    return(
      <>
      <h1>'mon pick yer seats</h1>
      {seats}
      </>
    )
  }
}

export default SeatPicker;
