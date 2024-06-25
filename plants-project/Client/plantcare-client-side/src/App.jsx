// App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import {NavBar} from './Components/Navigation/navbar.jsx'
import { Home } from "./Pages/Home/Home.jsx";
import { Plants } from "./Pages/Plants/Plants.jsx";

function App() {
    return (
        <div className="App">
            <Router>
                <NavBar/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/plants" element={<Plants />} />
                </Routes>
            </Router>
        </div>
    );
}

export default App;
