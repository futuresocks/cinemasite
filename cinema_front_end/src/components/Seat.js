import React from 'react';

const Seat = ({selected, number, seatClick})=>{

  //when clicked, sends the number up and changes to booked
  //if already PREbooked, unclickable - greyed out?

  const handleClick = () => {
    seatClick(number)
  }

  const imgSrc = selected ? "/img/selected.png" : "/img/available.png";

  return (
    <>
    <h3>{number}</h3>
    <img src = {imgSrc} onClick = {handleClick}/>
    </>
  )
}

export default Seat;
