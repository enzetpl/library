import React, {Component} from 'react';
import {Route, BrowserRouter as Router, Switch} from 'react-router-dom';
import Home from './components/Home';
import BookList from './components/BookList';
import CopyList from './components/CopyList';
import HireForm from './components/HireForm';
import Login from './components/Login';
import Register from './components/Register';
class App extends Component {
  render() {
    return(
      <div>
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route path='/books' exact={true} component={BookList}/>
            <Route path='/books/:id/copies/:copyid' component={HireForm}></Route>
            <Route path='/books/:id/copies' component={CopyList}></Route>
          </Switch>
        </Router>
      </div>
    )
  }
}

export default App;
