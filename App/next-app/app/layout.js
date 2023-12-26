import {Inter} from 'next/font/google'
import './globals.css'

const inter = Inter({subsets: ['latin']})

export const metadata = {
    title: 'Thương hiệu đồ da chất lượng cao, sang trọng và bền bỉ',
    description: 'Khám phá thương hiệu Duvis và trải nghiệm những sản phẩm da chất lượng cao, được thiết kế với phong cách sang trọng và độ bền bỉ đáng tin cậy. Từ ví da, túi xách đến giày da, Duvis mang đến cho bạn những sản phẩm đẳng cấp và đáng tin cậy. Đặt hàng ngay hôm nay để tận hưởng trải nghiệm mua sắm đầy trải nghiệm của Duvis.'}

export default function RootLayout({children}) {
    return (
        <html lang="en">
        <body>{children}</body>
        </html>
    )
}
