import logo from './logo.svg';
import './App.css';
import Header from "./components/Header";
import {Route, Routes} from "react-router";
import {BrowserRouter} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import HomePage from "./pages/HomePage";
import NotFound from "./pages/NotFound";
import TopPhat from "./pages/TopPhat";
import "react-toastify/dist/ReactToastify.css";
import CreateStudent from "./pages/CreateStudent";
import ListChuaThuong from "./pages/ListChuaThuong";

function App() {
  return (
      <>
          <BrowserRouter>
              <Routes>
                  <Route path="/" element={<HomePage/>}></Route>
                  <Route path="/top-phat" element={<TopPhat/>}></Route>
                  <Route path="/list-chua-thuong" element={<ListChuaThuong/>}></Route>
                  <Route path="/create-student" element={<CreateStudent/>}></Route>
                  <Route path="*" element={<NotFound/>}></Route>
              </Routes>
          </BrowserRouter>
          <ToastContainer/>
      </>
  );
}

export default App;
