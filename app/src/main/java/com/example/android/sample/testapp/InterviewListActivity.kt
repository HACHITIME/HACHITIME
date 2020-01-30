package com.example.android.sample.testapp

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.nifcloud.mbaas.core.NCMB
import com.nifcloud.mbaas.core.NCMBObject
import com.nifcloud.mbaas.core.NCMBQuery
import kotlinx.android.synthetic.main.toolbar.*

class InterviewListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview_list)
        tytle.text = "インタビュー"

        // 変数・配列の作成
        val interviewStudentIds = arrayListOf<String>() // 対象の学生ID
        val question = arrayListOf<String>() // 質問内容
        val answer = arrayListOf<String>() // 回答内容
        // パーツを取得
        val interviewList = findViewById<ListView>(R.id.interviewList) // GridView「facilityList」のIDを取得

        // 初期化
        NCMB.initialize(applicationContext,
            "d08392d55ee52427791b8cf068a24b9d3e0beab2329496ffdd7a1f71b08e8155",
            "04cd049bf76af6543ddfcc9b879f42ab643d44b2a2100f75a2818e72c47c2f8f")

        // FacilityMasterから施設情報を取得する
        val queryInterviewDetaile = NCMBQuery<NCMBObject>("InterviewDetaile")
        // queryInterviewDetaile.whereEqualTo("studentObjectId", obj.getString("objectId")) // 条件：対象学生のインタビュー詳細を指定
        queryInterviewDetaile.addOrderByAscending("questionNo") // 質問Noの昇順
        queryInterviewDetaile.findInBackground { objects2, e2 ->
            if (e2 != null) {
                // エラー
                Log.d("[Error]", e2.toString())
            } else {
                // 成功

                // FacilityMasterから施設情報を取得する
                val queryInterviewData = NCMBQuery<NCMBObject>("InterviewData")
                queryInterviewData.whereEqualTo("collegeId", intent.getStringExtra("PICK_ID"))
                queryInterviewData.addOrderByAscending("studentName")
                queryInterviewData.findInBackground { objects, e ->
                    if (e != null) {
                        // エラー
                        Log.d("[Error]", e.toString())
                    } else {
                        // 成功
                        for (obj2 in objects2) {
                            // DBからの取得情報を配列へ追加
                            interviewStudentIds.add(obj2.getString("studentObjectId"))
                            question.add(obj2.getString("question"))
                            answer.add(obj2.getString("answer"))
                        }

                        // interviewListのadapterを作成
                        val interviewListAdapter = InterviewListAdapter(this, objects, interviewStudentIds, question, answer)
                        // interviewListにadapterをセット
                        interviewList.adapter = interviewListAdapter
                    }
                }
            }
        }

        // ツールバータップ時の処理
        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, CampusInfoActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        modol_btn.setOnClickListener {
            super.onBackPressed()
        }

        /*
        // FacilityMasterから施設情報を取得する
        val queryInterviewDetaile = NCMBQuery<NCMBObject>("InterviewDetaile")
        // queryInterviewDetaile.whereEqualTo("studentObjectId", obj.getString("objectId")) // 条件：対象学生のインタビュー詳細を指定
        queryInterviewDetaile.addOrderByAscending("questionNo") // 質問Noの昇順
        queryInterviewDetaile.findInBackground { objects2, e2 ->
            if (e2 != null) {
                // エラー
                Log.d("[Error]", e2.toString())
            } else {
                // 成功

                // FacilityMasterから施設情報を取得する
                val queryInterviewData = NCMBQuery<NCMBObject>("InterviewData")
                queryInterviewData.whereEqualTo("collegeId", intent.getStringExtra("PICK_ID"))
                queryInterviewData.findInBackground { objects, e ->
                    if (e != null) {
                        // エラー
                        Log.d("[Error]", e.toString())
                    } else {
                        // 成功
                        for (obj2 in objects2) {
                            // DBからの取得情報を配列へ追加
                            interviewStudentIds.add(obj2.getString("studentObjectId"))
                            question.add(obj2.getString("question"))
                            answer.add(obj2.getString("answer"))
                        }
                        for (obj in objects) {
                            val targetQuestion = arrayListOf<String>() // 対象学生の質問内容
                            val targetAnswer = arrayListOf<String>() // 対象学生の回答内容
                            // DBからの取得情報を配列へ追加
                            studentImages.add(obj.getString("studentImage"))
                            studentNames.add(obj.getString("studentName"))
                            studentSubjects.add(obj.getString("subject"))
                            // 対象の質問内容と回答内容を取得
                            for (i in 0..question.size-1) {
                                if (interviewStudentIds[i] == obj.getString("objectId")) {
                                    targetQuestion.add(question[i])
                                    targetAnswer.add(answer[i])
                                }
                            }
                            // インタビュー詳細のアダプタを作成
                            val adapterInterviewDetaileList = InterviewListDetaileAdapter(this, targetQuestion, targetAnswer)
                            interviewDetailes.add(adapterInterviewDetaileList)
                        }

                        // interviewListのadapterを作成
                        val adapterInterviewList = InterviewListAdapter(this, studentImages, studentNames, studentSubjects, interviewDetailes)
                        // facilityListにadapterをセット
                        list.adapter = adapterInterviewList
                        // facilityDetaileListにadapterをセット

                    }
                }

                // facilityDetaileListにadapterをセット
                // list.getChildAt(1).findViewById<ListView>(R.id.interviewDetaileList).interviewDetaileList.adapter = adapterInterviewDetaileList
            }
        }*/


        /*
        // FacilityMasterから施設情報を取得する
        val queryInterviewData = NCMBQuery<NCMBObject>("InterviewData")
        queryInterviewData.whereEqualTo("collegeId", intent.getStringExtra("PICK_ID"))
        queryInterviewData.findInBackground { objects, e ->
            if (e != null) {
                // エラー
                Log.d("[Error]", e.toString())
            } else {
                // 成功
                for (obj in objects) {
                    // DBからの取得情報を配列へ追加
                    studentImages.add(obj.getString("studentImage"))
                    studentNames.add(obj.getString("studentName"))
                    studentSubjects.add(obj.getString("subject"))
                    studentIds.add(obj.getString("objectId"))


                    // FacilityMasterから施設情報を取得する
                    val queryInterviewDetaile = NCMBQuery<NCMBObject>("InterviewDetaile")
                    queryInterviewDetaile.whereEqualTo("studentObjectId", obj.getString("objectId")) // 条件：対象学生のインタビュー詳細を指定
                    queryInterviewDetaile.addOrderByAscending("questionNo") // 質問Noの昇順
                    queryInterviewDetaile.findInBackground { objects2, e2 ->
                        if (e2 != null) {
                            // エラー
                            Log.d("[Error]", e.toString())
                        } else {
                            // 成功
                            val question = arrayListOf<String>()
                            val answer = arrayListOf<String>()
                            for (obj2 in objects2) {
                                // DBからの取得情報を配列へ追加
                                question.add(obj2.getString("question"))
                                answer.add(obj2.getString("answer"))
                            }
                            // interviewDetaileListのadapterを作成
                            val adapterInterviewDetaileList = InterviewListDetaileAdapter(this, question, answer)
                            interviewDetaile.add(adapterInterviewDetaileList)



                            // facilityDetaileListにadapterをセット
                            // list.getChildAt(1).findViewById<ListView>(R.id.interviewDetaileList).interviewDetaileList.adapter = adapterInterviewDetaileList
                        }
                    }







                }
                // interviewListのadapterを作成
                val adapterInterviewList = InterviewListAdapter(this, studentImage, studentName, studentSubject, objectId, interviewDetaile)
                // facilityListにadapterをセット
                list.adapter = adapterInterviewList


                // val a = list.getChildAt(0).findViewById<TextView>(R.id.studentName).text

            }
        }
        */


    }
}
