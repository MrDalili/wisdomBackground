package com.smart.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LM_Code
 * @create 2019-05-09-20:45
 */
@Data
public class AttendanceItem implements Serializable {
    String attendance_id;//考勤id
    String courseitem_id;//这一节课的id
    String course_id;//课程id
    String name;//课程名
    Date time;//上课时间
    String status;//到勤状态
    String head_up_rate;//抬头率
    String goal;//总分
    String teacher_id;//老师id
    String teacher_name;//老师姓名
    String classroom_id;//教室id
    String course_note;//课程note
    String student_id;//学生id
    String student_name;//学生名
}
