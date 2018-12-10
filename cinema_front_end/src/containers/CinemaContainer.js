import React, {Component} from 'react';
import FilmsContainer from './FilmsContainer.js';

class CinemaContainer extends Component{
  constructor(props){
    super(props);
    this.state = {
      movies: null
    }
  }

  componentDidMount(){
    fetch("/api/movies")
    .then(data => data.json())
    .then(jsonData => {
      let movies = jsonData._embedded.movies;
      this.setState({movies});
  })
}

render(){

  //filter today's movies

  return (
    <>
    <h1>TODAY'S FILMS</h1>
    <FilmsContainer movieData = {this.state.movies}/>
    </>
  )
}

}

export default CinemaContainer;
