package cz.utb.fai.subjectinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cz.utb.fai.subjectinfo.databinding.ActivityDetailBinding
import cz.utb.fai.subjectinfo.databinding.ActivitySubjectinfoBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val zkratka = intent.getStringExtra("MYDATA")

        binding.textZkratka.text = zkratka.toString()


    }
}