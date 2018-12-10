import React from 'react';

const Seat = (props)=>{
  const booked = props.booked ? "deffo booked" : "no booked";

  return (
    <p>I'm seat {props.number} and I'm {booked}</p>
  )
}

export default Seat;
