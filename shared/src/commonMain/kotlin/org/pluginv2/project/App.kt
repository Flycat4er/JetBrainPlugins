package org.pluginv2.project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Plugin(
    val id: String,
    val name: String,
    val vendor: String,
    val category: String,
    val priceType: String,
    val description: String,
    val rating: Int,
    val downloads: String
)

val pluginList = listOf(

    Plugin("001", "JetBrains AI Assistant", "JetBrains s.r.o.", "Staff-picked IntelliJ IDEA Plugins", "Freemium", "A set of AI-powered features and coding agents built into JetBrains IDEs that use IDE code intelligence to support everyday development tasks.", 3, "217,277,303"),
    Plugin("002", "Junie, the AI coding agent", "JetBrains s.r.o.", "Staff-picked IntelliJ IDEA Plugins", "Free", "Junie is an AI coding agent by JetBrains that handles tasks autonomously or in collaboration with a developer. Developers can either fully delegate routine tasks to Junie or partner with it on more complex ones", 4, "33,688,984"),
    Plugin("003", "Spring Debugger", "JetBrains s.r.o.", "Staff-picked IntelliJ IDEA Plugins", "Free", "The Spring Debugger helps you understand what’s going on behind the scenes, so you can resolve issues faster, verify application state, and write high-quality, maintainable code.", 5, "1,398,428"),
    Plugin("004", "Kotlin Multiplatform", "JetBrains s.r.o.", "Staff-picked IntelliJ IDEA Plugins", "Free", "This plugin for IntelliJ IDEA and Android Studio enables you to develop Kotlin Multiplatform applications targeting Android, iOS, desktop, web, and server.", 4, "2,111,468"),
    Plugin("005", "Develocity", "Gradle Technologies", "Staff-picked IntelliJ IDEA Plugins", "Free", "The Develocity IntelliJ plugin brings build insights and test analytics directly into your IDE. It seamlessly integrates Develocity and Build Scan capabilities to help you identify bottlenecks and fix flaky tests without ever leaving IntelliJ IDEA or Android Studio.", 5, "115,801"),
    Plugin("006", "Key Promoter X", "Hal's Corner", "Staff-picked IntelliJ IDEA Plugins", "Free", "The Key Promoter X helps you to learn essential shortcuts while you work. When you use the mouse on a button inside the IDE, the Key Promoter X shows you the keyboard shortcut that you should have used instead.", 5, "8,204,302"),
    Plugin("007", "GitHub Copilot", "GitHub", "Top Downloaded IntelliJ IDEA Plugins", "Free", "GitHub Copilot is your AI-powered coding assistant, offering assistance throughout your software development journey.", 3, "53,644,243"),
    Plugin("008", "Subversion", "JetBrains s.r.o.", "Top Downloaded IntelliJ IDEA Plugins", "Free", "Provides integration with Subversion VCS. Supports Subversion 1.7 and above. Requires command line svn client.", 4, "47,584,417"),
    Plugin("009", "Qoder CN", "Alibaba Cloud", "Top Downloaded IntelliJ IDEA Plugins", "Free", "Qoder CN is an AI coding assistant powered by Alibaba Cloud. It provides code completion, Ask, multi-file editing, and coding-agent capabilities, together with enterprise authentication, organization, model, and knowledge-base features.", 4, "38,841,094"),
    Plugin("010", "Chinese (Simplified)", "JetBrains s.r.o.", "Top Downloaded IntelliJ IDEA Plugins", "Free", "The Chinese Language Pack localizes the UI of IntelliJ-based IDEs into Chinese.", 4, "39,838,000"),
    Plugin("011", "Kotlin", "JetBrains s.r.o.", "Top Downloaded IntelliJ IDEA Plugins", "Free", "Provides language support for Kotlin, a modern programming language designed to make developers happier.", 5, "37,791,319"),
    Plugin("012", "CodeLoupe", "Filipe Baptista", "New IntelliJ IDEA Plugins", "Free", "CodeLoupe mines your project's Git history to surface which files change most and are most complex, visualized as an interactive circle-packing map.", 5, "9"),
    Plugin("013", "Sectionary", "Gunblade Games GmbH", "New IntelliJ IDEA Plugins", "Free trial", "Sectionary turns comment-based sections into a visual guide to your code in Rider, IntelliJ IDEA, PyCharm, and WebStorm.", 5, "7"),
    Plugin("014", "Qwen Code for IDEs", "JetBrains", "New IntelliJ IDEA Plugins", "Free", "Unofficial JetBrains IDE tool for launching Qwen Code from the toolbar with reusable prompt presets.", 0, "14"),
    Plugin("015", "MyCode", "ZhouXiaosong", "New IntelliJ IDEA Plugins", "Free", "Model requests go to the provider you configure. Reading files, editing code, and running commands all happen inside the IDE process.", 0, "5"),
    Plugin("016", "MAIFlow", "Conceptual Arts", "New IntelliJ IDEA Plugins", "Free", "Manage MAIFlow tasks from a focused IntelliJ Platform tool window. Connect with the same API token used by MAIFlow MCP clients, create and update tasks, filter your workspace, and open full task pages in MAIFlow.", 0, "3"),
    Plugin("017", "Accenture Java Formatter", "Lemuel Adane", "New IntelliJ IDEA Plugins", "Free", "Enterprise-grade Java code formatting plugin for IntelliJ IDEA, implementing Accenture Java code style rules.", 0, "2"),
    Plugin("018", "PHP composer.json support", "Piotr Sliwa", "Top-rated IntelliJ IDEA Plugins", "Free", "This plugin adds auto completion and inspections support for composer.json file in PHP projects.", 5, "864,845"),
    Plugin("019", "MyBatisCodeHelperPro", "bruce ge", "Top-rated IntelliJ IDEA Plugins", "Free trial", "MyBatisCodeHelperPro plugin for java mybatis framework, provide auto completion inspection, code generation, make mybatis easy to use", 5, "1,415,227"),
    Plugin("020", "Gerry Themes Pro", "Gerry Themes", "Top-rated IntelliJ IDEA Plugins", "Free trial", "Gerry Themes Pro is a refined themes collection for IntelliJ-based IDEs, designed for a comfortable development experience.", 5, "546,293")
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
            background = Color(0xFF1E1E24),
            surface = Color(0xFF2B2B36),
            onBackground = Color.White,
            onSurface = Color.White
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6200EE),
            background = Color(0xFFFFFDFE),
            surface = Color(0xFFF3F0F5),
            onBackground = Color.Black,
            onSurface = Color.Black
        )
    }
    MaterialTheme(colorScheme = colorScheme, content = content)
}

@Composable
fun App() {
    var isDarkTheme by remember { mutableStateOf(true) }
    var selectedPlugin by remember { mutableStateOf<Plugin?>(null) }

    AppTheme(darkTheme = isDarkTheme) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            if (selectedPlugin == null) {
                PluginListScreen(
                    onPluginClick = { selectedPlugin = it },
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = { isDarkTheme = !isDarkTheme }
                )
            } else {
                PluginDetailScreen(
                    plugin = selectedPlugin!!,
                    onBack = { selectedPlugin = null },
                    isDarkTheme = isDarkTheme,
                    onThemeToggle = { isDarkTheme = !isDarkTheme }
                )
            }
        }
    }
}

@Composable
fun TopBarCentered(
    title: String,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    onBack: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .height(56.dp)
    ) {
        if (onBack != null) {
            Text(
                text = "←",
                fontSize = 32.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable { onBack() }
                    .padding(8.dp)
            )
        }

        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )

        Button(
            onClick = onThemeToggle,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(if (isDarkTheme) "Светлая" else "Темная")
        }
    }
}

@Composable
fun PluginListScreen(onPluginClick: (Plugin) -> Unit, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredPlugins = pluginList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TopBarCentered(
            title = "JetBrainsPlugin",
            isDarkTheme = isDarkTheme,
            onThemeToggle = onThemeToggle
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            placeholder = { Text("Поиск по имени...") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(filteredPlugins) { plugin ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { onPluginClick(plugin) },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(60.dp).clip(CircleShape).background(Color.Gray.copy(alpha = 0.3f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(plugin.name.take(1), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text("#${plugin.id}", color = Color.Gray, fontSize = 12.sp)
                            Text(plugin.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            PriceTag(plugin.priceType)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PluginDetailScreen(plugin: Plugin, onBack: () -> Unit, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        TopBarCentered(
            title = "JetBrainsPlugin",
            isDarkTheme = isDarkTheme,
            onThemeToggle = onThemeToggle,
            onBack = onBack
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.size(150.dp).clip(CircleShape).background(Color.Gray.copy(alpha = 0.3f)),
            contentAlignment = Alignment.Center
        ) {
            Text(plugin.name.take(1), fontSize = 60.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("#${plugin.id}", color = Color.Gray, fontSize = 14.sp)
        Text(plugin.name, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(plugin.category, fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(8.dp))
        PriceTag(plugin.priceType)

        Spacer(modifier = Modifier.height(24.dp))
        Text(plugin.description, fontSize = 14.sp, modifier = Modifier.padding(horizontal = 16.dp))

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(color = Color.Gray.copy(alpha = 0.5f))
        Spacer(modifier = Modifier.height(16.dp))

        Text("Оценка плагина", fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.align(Alignment.Start)) {
            repeat(5) { index ->
                Text(
                    text = "★",
                    color = if (index < plugin.rating) Color(0xFFFFC107) else Color.Gray,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun PriceTag(type: String) {
    val color = when (type.lowercase()) {
        "free" -> Color(0xFF4CAF50)
        "freemium" -> Color(0xFF9C27B0)
        "free trial" -> Color(0xFFFF9800)
        else -> Color.Gray
    }

    Box(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(color).padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(type, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}