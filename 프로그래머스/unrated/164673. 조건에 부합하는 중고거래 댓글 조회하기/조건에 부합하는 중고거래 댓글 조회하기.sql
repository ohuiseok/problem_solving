-- 코드를 입력하세요
SELECT used_goods_board.TITLE,used_goods_board.BOARD_ID,used_goods_reply.REPLY_ID,used_goods_reply.WRITER_ID,used_goods_reply.CONTENTS,DATE_FORMAT(used_goods_reply.created_date,'%Y-%m-%d') AS CREATED_DATE
from used_goods_board
join used_goods_reply
on used_goods_board.board_id = used_goods_reply.board_id
where DATE(used_goods_board.created_date) between "2022-10-01" and "2022-10-31"
order by used_goods_reply.created_date,used_goods_board.title 