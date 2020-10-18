import React, {useState} from 'react';
import {axios} from "@/utils";


const connect = () => {

  const [ state, setState ] = useState({
    host: '127.0.0.1',
    port: 6379
  });

  const handleSubmit = async (e) => {
    e.preventDefault()
    const response = await axios.post("dd").then().catch(err => console.log(err));
    console.log(state)
  }

  const setValue = (e) => {
    setState({ ...state, [e.target.name]: e.target.value })
  }

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <span className="new">Host:</span>
        <input type="text"
               name="host"
               placeholder="127.0.0.1"
               onChange={setValue}
        />
        <br/>
        <span className="new">Port:</span>
        <input type="text"
               name="port"
               placeholder="6379"
               onChange={setValue}
        />
        <br/>
        <span className="new">Auth:</span>
        <input type="password"
               name="auth"
               onChange={setValue}
        />
        <br/>
        <span className="new">Name:</span>
        <input type="text"
               name="name"
               onChange={setValue}
        />
        <br/>
        <input type="submit" value="提交"/>
      </form>
      <button onClick={() => console.log(`button`)}>ddd</button>
    </div>
  )
}

export default connect