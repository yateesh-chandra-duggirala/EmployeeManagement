import './App.css';
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Employee from './Components/Employee';
import AddOrUpdateEmployee from './Components/AddOrUpdateEmployee';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path = "/" element = {<Employee/>}/>
          <Route path = "/add" element = {<AddOrUpdateEmployee/>} />
          <Route path = "/add/:employeeId" element = {<AddOrUpdateEmployee/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
