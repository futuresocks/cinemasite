import React, {Component} from 'react';

const FilmDetail = ({movie}) => {

  debugger;

  if(!movie) return null;
  //filter screenings by date here?

  const screenings = movie.screenings.map(screening => <li>{screening.time}</li>);

  return (
    <>
    <img src = {movie.img}/>
    <p>{movie.title}</p>
    {screenings}
    </>
  )
}

export default FilmDetail;
