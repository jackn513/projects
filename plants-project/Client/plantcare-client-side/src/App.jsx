// App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import {NavBar} from './Components/Navigation/navbar.jsx'
import { Home } from "./Pages/Home/Home.jsx";
import {Plants } from './Pages/Plants/Plants.jsx'
import {SinglePlant} from "./Pages/Single Plant/SinglePlant.jsx";
import { Footer } from './Components/Footer/Footer.jsx'
import { Soils } from "./Pages/Soils/Soils.jsx";

function App() {
    return (
        <div className="App">
            <Router>
                <NavBar/>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/plants" element={<Plants />} />
                    <Route path="/plant/:id" element={<SinglePlant/>} />
                    <Route path={'/soils'} element={<Soils/>}/>
                </Routes>
            </Router>
            <Footer/>
        </div>
    );
}

export default App;
