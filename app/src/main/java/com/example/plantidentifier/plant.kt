import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantidentifier.PlantIdentifierViewModel

@Composable
fun PlantIdentifierScreen(viewModel: PlantIdentifierViewModel) {
    val primaryGreen = Color(0xFF4CAF50)
    val lightGreen = Color(0xFFE8F5E9)
    val darkGreen = Color(0xFF2E7D32)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        color = lightGreen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Plant Identifier",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = darkGreen,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                viewModel.imageUri?.let { uri ->
                    // Here you would load and display the captured image
                    // For now, we'll just show a placeholder text
                    Text("Image Captured", color = Color.Gray)
                } ?: Text("No Image Captured", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Trigger image capture */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryGreen)
            ) {
                Text("Capture Image", fontSize = 18.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { viewModel.identifyPlant() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryGreen)
            ) {
                Text("Identify Plant", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Identification Result:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = darkGreen
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = viewModel.identificationResult ?: "No plant identified yet",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}