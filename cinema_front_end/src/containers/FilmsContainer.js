import React, {Component} from 'react';
import FilmDetail from '../components/FilmDetail';

const FilmsContainer = ({movieData}) => {

  if(!movieData) return null;

  const movies = movieData.map(movie => <FilmDetail movie={movie}/>)

  return (
    <>
    {movies}
    </>
  )

}

export default FilmsContainer;
