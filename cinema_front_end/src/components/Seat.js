import React from 'react';

const Seat = ({selected, number, seatClick})=>{

  //when clicked, sends the number up and changes to booked
  //if already PREbooked, unclickable - greyed out?

  const handleClick = () => {
    seatClick(number)
  }

  const booked = selected ? "deffo selected" : "no selected";

  return (
    <p onClick = {handleClick}>I'm seat {number} and I'm {booked}</p>
  )
}

export default Seat;
