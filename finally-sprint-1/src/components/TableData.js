import React from 'react';

function TableData(props) {
    return (
        <>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên cột 1</th>
                    <th scope="col">Tên cột 2</th>
                    <th scope="col">Tên cột 3</th>
                </tr>
                </thead>
                <tbody>
                {/* Chèn dữ liệu của bạn ở đây */}
                </tbody>
            </table>

        </>
    );
}

export default TableData;