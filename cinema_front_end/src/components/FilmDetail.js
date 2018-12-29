import React from 'react';
import {Link} from 'react-router-dom';
import moment from 'moment';

const FilmDetail = ({movie}) => {

  //filter screenings by date here?
  const screenings = movie._embedded.screenings
                    .map((screening, index) => {
                      return <Link key = {index}
                                   to={"screenings/" + screening.id}>
                                   {moment(screening.dateTime).format('HH:mm')}
                             </Link>
                    })
                    .sort((linkA, linkB) => linkB.key - linkA.key)

  return (
    <>
    <img alt = {movie.title} src = {movie.img}/>
    <p>{movie.title}</p>
    {screenings}
    </>
  )
}

export default FilmDetail;
