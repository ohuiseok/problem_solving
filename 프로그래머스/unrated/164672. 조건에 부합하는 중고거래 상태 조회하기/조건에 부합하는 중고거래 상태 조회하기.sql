-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, 
case when STATUS = "SALE" then "판매중"
     when STATUS = "RESERVED" then "예약중"
     when STATUS = "DONE" then "거래완료"
end as status
from USED_GOODS_BOARD
where CREATED_DATE = "2022-10-05"
order by board_id desc