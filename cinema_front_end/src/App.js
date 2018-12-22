import React, { Component } from 'react';
import CinemaContainer from './containers/CinemaContainer';
import ScreeningContainer from './containers/ScreeningContainer';
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
        </Switch>
      </Router>
      </>
    );
  }
}

export default App;
