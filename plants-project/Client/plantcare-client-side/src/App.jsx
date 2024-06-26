// App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import {NavBar} from './Components/Navigation/navbar.jsx'
import { Home } from "./Pages/Home/Home.jsx";
import {Plants } from './Pages/Plants/Plants.jsx'
import {SinglePlant} from "./Pages/Single Plant/SinglePlant.jsx";

function App() {
    return (
        <div className="App">
            <Router>
                <NavBar/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/plants" element={<Plants />} />
                    <Route path="/plant/:id" element={<SinglePlant/>} />
                </Routes>
            </Router>
            <footer>This is the footer</footer>
        </div>
    );
}

export default App;
