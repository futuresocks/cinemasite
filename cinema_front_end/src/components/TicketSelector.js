import React, {Component} from 'react';
import prices from '../constants/Prices';

class TicketSelector extends Component {
  constructor(props){
    super(props);
    this.state = {
      tickets: {}
    };
    for(let ticketLevel in prices){
      this.state.tickets[ticketLevel] = 0;
    }
    this.handleChange = this.handleChange.bind(this);
    this.generateOptions = this.generateOptions.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(evt){
    evt.preventDefault();
    this.props.handleSubmit();
  }

  handleChange(evt){
    let tickets = this.state.tickets;
    tickets[evt.target.id] = evt.target.value;
    this.setState({tickets}, () => {
      this.props.handleSelect(this.state.tickets)
    });
  }

  generateOptions(){
    return [0,1,2,3,4,5].map((number, index) => <option key = {index} value ={number}>{number}</option>)
  }

  render(){

    const ticketOptions = Object.keys(prices).map(ticketLevel => {
      return (
        <>
        <label htmlFor={ticketLevel}>{ticketLevel.toUpperCase()}:</label>
        <select id= {ticketLevel} onChange = {this.handleChange} value = {this.state.tickets[ticketLevel]}>
        {this.generateOptions()}
        </select>
        </>
      )
    })

    return(
      <>
      <form onSubmit = {this.handleSubmit}>
      {ticketOptions}
      <input type = "submit" value = "Choose Your Seats"/>
      </form>
      </>
    )
  }
}

export default TicketSelector;
