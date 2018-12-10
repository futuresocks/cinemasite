import React, {Component} from 'react';

class CinemaContainer extends Component{
  constructor(props){
    super(props);
    this.state = {
      data: {}
    }
  }

  componentDidMount(){
    fetch("/api/movies")
    .then(data => data.json())
    .then(movies => console.log(movies))
  }

render(){

  return (
    <>
    <h1>TODAY'S FILMS</h1>
    </>
  )
}

}

export default CinemaContainer;
