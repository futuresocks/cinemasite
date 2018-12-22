import React from 'react';
import FilmDetail from '../components/FilmDetail';

const FilmsContainer = ({movieData}) => {

  if(!movieData) return null;

  const movies = movieData.map((movie, index) => <FilmDetail key = {index} movie={movie}/>)

  return (
    <>
    {movies}
    </>
  )

}

export default FilmsContainer;
