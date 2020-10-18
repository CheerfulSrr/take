import React from 'react';
import {HashRouter as Router,BrowserRouter, Link, Route} from "react-router-dom";
import Connect from '@/Connect'

export default () => {
  return (
    <Router>
      <div className="top">
        <ul>
          <li><Link to="/new">新建连接</Link></li>
        </ul>
      </div>
      <Route path="/new" component={Connect}/>
    </Router>
  )
}