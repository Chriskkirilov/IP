import React from 'react'
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import AddPoll from "./components/AddPoll";

function App() {
  return (
      <div>
          <Router>
                <div className="container">
                    <Switch>
                        <Route path="/addPoll" component={AddPoll}></Route>
                    </Switch>
                </div>
          </Router>
      </div>
  );
}

export default App;
