import React, {Component} from 'react';
import FilmsContainer from './FilmsContainer.js';
import Request from '../helpers/Request.js';
import moment from 'moment';

class CinemaContainer extends Component{
  constructor(props){
    super(props);
    this.state = {
      screenings: null
    }
  }

  componentDidMount(){

    const todaysDate = moment().format('L');

    const request = new Request();

    request.get(`/api/screenings/datesearch/${todaysDate}`)
    .then(screenings => this.setState({screenings}))
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
