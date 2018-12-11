import React from 'react';

const Seat = (props)=>{

  //when clicked, sends the number up and changes to booked
  //if already PREbooked, unclickable - greyed out?


  const booked = props.selected ? "deffo selected" : "no selected";

  return (
    <p>I'm seat {props.number} and I'm {booked}</p>
  )
}

export default Seat;
