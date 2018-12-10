import React, {Component} from 'react';
import {Link} from 'react-router-dom';

const FilmDetail = ({movie}) => {

  //filter screenings by date here?

  const screenings = movie._embedded.screenings.map(screening => <Link to={"screenings/" + screening.id}>{screening.time}</Link>)

  return (
    <>
    <img src = {movie.img}/>
    <p>{movie.title}</p>
    {screenings}
    </>
  )
}

export default FilmDetail;
