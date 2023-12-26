import React from 'react';

function Header(props) {
    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container">
                    <a className="navbar-brand" href="#">Logo</a>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item active">
                                <a className="nav-link" href="#">Trang Chủ <span
                                    className="sr-only">(current)</span></a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Tính Năng</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Giá Cả</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link disabled" href="#">Vô Hiệu Hóa</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </>

    );
}

export default Header;