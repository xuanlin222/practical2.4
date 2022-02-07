package com.example.practical24
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practical24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding  //lateinit = assign value later

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val s: Student = Student("W123", "John") //s = identifier name
        // can be like this -> val s = Student("W123", "John")
        binding.myData = s

        //binding.tvID.text = s.studentID //way to retrieve data, s. refer to line 17
        binding.btnUpdate.setOnClickListener(){
            s.studentName = "Alex"
            binding.apply {
                invalidateAll()  //to change the name from john to alex
            }
        }
        //val tv :TextView = findviewbyId(R.id.tvName)
    }
}