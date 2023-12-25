import logo from './logo.svg';
import './App.css';
import Header from "./components/Header";
import {Route, Routes} from "react-router";
import {BrowserRouter} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import HomePage from "./pages/HomePage";
import NotFound from "./pages/NotFound";
import Page1 from "./pages/Page1";

function App() {
  return (
      <>
          <BrowserRouter>
              <Routes>
                  <Route path="/" element={<HomePage/>}></Route>
                  <Route path="/page1" element={<Page1/>}></Route>
                  <Route path="*" element={<NotFound/>}></Route>
              </Routes>
          </BrowserRouter>
          <ToastContainer/>
      </>
  );
}

export default App;
