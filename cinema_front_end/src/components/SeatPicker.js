import React, {Component} from 'react';
import Seat from './Seat';

class SeatPicker extends Component{
  constructor(props){
    super(props);
    this.state = {}
  }

  render(){

    const screeningSeats = this.props.screening._embedded.room.seats
                          .map(seat => seat.number);

    const bookedSeats = this.props.screening._embedded.tickets
                        .map(ticket => ticket.seat.number);

    const seats = screeningSeats.map(seatNo => {
      return bookedSeats.includes(seatNo) ? <Seat number = {seatNo} booked = {true}/> : <Seat number = {seatNo} booked = {false}/>
    })

    return(
      <>
      <h1>'mon pick yer seats</h1>
      {seats}
      </>
    )
  }
}

export default SeatPicker;
