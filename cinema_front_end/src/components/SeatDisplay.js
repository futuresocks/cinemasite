import React from 'react';

const SeatDisplay = ({selectedSeats}) => {

  if(selectedSeats.length === 0) return null;

  const seatsToString = selectedSeats.sort().join(", ")

  return (
    <p>You have selected: {seatsToString}</p>
  )

}

export default SeatDisplay;
