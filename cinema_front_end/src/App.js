import React, { Component } from 'react';
import CinemaContainer from './containers/CinemaContainer';
import ScreeningContainer from './containers/ScreeningContainer';
import BookingConfirmation from './components/BookingConfirmation';
import Logo from './components/Logo';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';


class App extends Component {
  render() {
    return (
      <>
      <Logo/>
      <Router>
        <Switch>
          <Route exact path = "/" component = {CinemaContainer}/>
            <Route path = "/screenings/:id" render = {(props) =>
                <ScreeningContainer screeningId = {props.match.params.id}/>
              }/>
          <Route path = "/confirmation" component = {BookingConfirmation}/>
        </Switch>
      </Router>
      </>
    );
  }
}

export default App;
