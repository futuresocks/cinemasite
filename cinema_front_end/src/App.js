import React, { Component } from 'react';
import CinemaContainer from './containers/CinemaContainer';
import {BrowserRouter as Router, Route} from 'react-router-dom';


class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path = "/" component = {CinemaContainer}/>
      </Router>
    );
  }
}

export default App;
