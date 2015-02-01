use bookstore;

create table guestbook(
    gst_id INT AUTO_INCREMENT not null primary key,
    gst_user VARCHAR(10) not null,
    gst_title VARCHAR(100) not null,
    gst_content TEXT,
    gst_time TIMESTAMP not null,
    gst_ip VARCHAR(15) not null);