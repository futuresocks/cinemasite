import React from 'react'
import "./SeatRow.css"

const SeatRow = ({seats, generator}) => {

  //change an array of seat objects into an array of seats and unavailable seats
  const row = seats.map(seat => generator(seat.number))

  return (
    <div class= "seatrow">
    {row}
    </div>
  )
}

export default SeatRow
