import React, {Component} from 'react';

class SeatPicker extends Component{
  constructor(props){
    super(props);
    this.state = {}
  }

  render(){

    if(!this.props.screening) return null;
    console.log(this.props.screening);

    return(
      <h1>'mon pick yer seats</h1>
    )
  }
}

export default SeatPicker;
