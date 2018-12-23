import React, {Component} from 'react';
import SeatRow from './SeatRow'
import Seat from './Seat';
import UnavailableSeat from './UnavailableSeat';
import SeatDisplay from './SeatDisplay';

class SeatPicker extends Component{
  constructor(props){
    super(props);
    this.state = {
      seatmap: this.props.seatmap,
      selectedSeats: [],
      screeningSeats: this.props.screening._embedded.room.seats
      .map(seat => seat.number),
      bookedSeats: this.props.screening._embedded.tickets
      .map(ticket => ticket.seat.number)
    }
    this.seatGenerator = this.seatGenerator.bind(this);
    this.handleSeatClick = this.handleSeatClick.bind(this);
    this.handleButtonClick = this.handleButtonClick.bind(this);
    this.rowGenerator = this.rowGenerator.bind(this);
  }

  handleSeatClick(seatNo){
    if(this.state.selectedSeats.length < this.props.seatLimit){
      let selectedSeats;
      if(!this.state.selectedSeats.includes(seatNo)){
        selectedSeats = [...this.state.selectedSeats, seatNo];
      } else {
        selectedSeats = [...this.state.selectedSeats].filter(seat => seat !== seatNo);
      }
      this.setState({selectedSeats})
    } else {
      if(this.state.selectedSeats.includes(seatNo)){
        let selectedSeats = [...this.state.selectedSeats].filter(seat => seat !== seatNo);
        this.setState({selectedSeats})
      }
    }
  }

  handleButtonClick(){
    if(this.state.selectedSeats.length === this.props.seatLimit){
      const seatIDs = this.props.screening._embedded.room.seats
                      .filter(seat => this.state.selectedSeats.includes(seat.number))
                      .map(seat => seat.id)
      this.props.handleClick(seatIDs);
    }
  }

  rowGenerator(){
    let rowLetters = Object.keys(this.props.seatmap)
    return rowLetters.map(letter => <SeatRow seats= {this.props.seatmap[letter]} generator = {this.seatGenerator}/>)
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

    const seats = this.rowGenerator();

    return(
      <>
      <h1>'mon pick yer seats</h1>
      {seats}
      <SeatDisplay selectedSeats = {this.state.selectedSeats}/>
      <button onClick = {this.handleButtonClick}>Order Seats</button>
      </>
    )
  }
}

export default SeatPicker;
