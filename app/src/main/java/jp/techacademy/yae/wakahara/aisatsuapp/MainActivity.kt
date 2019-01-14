package jp.techacademy.yae.wakahara.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // イベントリスナを設定します。
        button.setOnClickListener { showTimePickerDialog() }
    }

    // TimePickerDialog を表示して、設定された時間に応じた挨拶をTextViewに表示します。
    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                textView.text = getAisatsu(hour)
            },
            0,
            0,
            true
        )
        timePickerDialog.show()
    }

    // 時間から挨拶を取得します。
    private fun getAisatsu(hour: Int): String {
        if (2 <= hour && hour <= 9) return "おはよう"
        else if (10 <= hour && hour <= 17) return "こんにちは"
        else return "こんばんは" // 18時以降、2時未満
    }
}
