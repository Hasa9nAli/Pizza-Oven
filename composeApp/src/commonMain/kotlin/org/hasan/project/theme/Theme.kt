import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4B3C38),
    secondary = Color(0xFF4B3C38),
    tertiary = Color(0xFF4B3C38),
    background = Color(0x99FFFFFF),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFFEEEEEE),
    onSurface = Color(0xFFEEEEEE),
    // Add other dark theme colors as needed
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xCC4B3C38),  // Note: 0xCC is alpha channel (80% opacity)
    secondary = Color(0xFF4B3C38),
    tertiary = Color(0xFF4B3C38),
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color(0xCC121212),
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    // Add other light theme colors as needed
)

@Immutable
data class ExtendedColors(
    val adaptiveText: Color,
    val secondaryText: Color,
    val disabledText: Color
    // Add other custom colors as needed
)

val lightExtendedColors = ExtendedColors(
    adaptiveText = Color(0xFF1C1B1F),  // Dark gray for light theme
    secondaryText = Color(0xFF1C1B1F).copy(alpha = 0.6f),
    disabledText = Color(0xFF1C1B1F).copy(alpha = 0.38f)
)

val darkExtendedColors = ExtendedColors(
    adaptiveText = Color(0xFFEEEEEE),  // Light gray for dark theme
    secondaryText = Color(0xFFEEEEEE).copy(alpha = 0.6f),
    disabledText = Color(0xFFEEEEEE).copy(alpha = 0.38f)
)

val LocalExtendedColors = staticCompositionLocalOf { lightExtendedColors }

@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkExtendedColors else lightExtendedColors
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalExtendedColors provides colors) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

