import React from 'react';
import './Seat.css';

const UnavailableSeat = ({number}) => (
  <div id = "seat">
  <h3>{number}</h3>
  <img alt = {number} src="/img/unavailable.png"/>
  </div>
)

export default UnavailableSeat
