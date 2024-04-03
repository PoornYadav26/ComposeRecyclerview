package com.example.composerecyclerview.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composerecyclerview.model.StudentDetails
import com.example.composerecyclerview.util.StudDetails

class StudentListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          Column{
              DetailsContent()
          }
        }

    }

    @Composable
    fun DetailsContent() {
        val item = remember { StudDetails.StudentDetailsList}
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(item!!) {
                StudentCard(stud = it)
            }
        }
    }


    @Composable
    fun StudentCard(stud: StudentDetails) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(16.dp))

        ) {

            Row(modifier = Modifier.padding(20.dp)) {
                Image(painter = painterResource(stud.image), contentDescription = "Profile Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(90.dp)
                        .clip((CircleShape)))
                Column(modifier = Modifier.weight(1f),
                    Arrangement.Center) {
                    Text(
                        text = stud.name,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(
                        text = "Age :- "+stud.age.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(
                        text = "Gender :- "+stud.gender,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(bottom = 5.dp))
                    Text(
                        text = "Father Name :- "+stud.father_name,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                }

            }
        }
    }



}

