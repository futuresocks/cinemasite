import React from 'react';
import './Seat.css';

const Seat = ({selected, number, seatClick}) => {

  const handleClick = () => {
    seatClick(number)
  }

  const imgSrc = selected ? "/img/selected.png" : "/img/available.png";

  return (
    <div id = "seat">
    <h3>{number}</h3>
    <img src = {imgSrc} onClick = {handleClick}/>
    </div>
  )
}

export default Seat;
