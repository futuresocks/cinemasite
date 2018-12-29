import React from 'react';
import {Link} from 'react-router-dom';

const FilmDetail = ({movie}) => {

  //filter screenings by date here?
  debugger;
  const screenings = movie._embedded.screenings.map((screening, index) => <Link key = {index} to={"screenings/" + screening.id}>{screening.time}</Link>)

  return (
    <>
    <img alt = {movie.title} src = {movie.img}/>
    <p>{movie.title}</p>
    {screenings}
    </>
  )
}

export default FilmDetail;
